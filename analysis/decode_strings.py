#!/usr/bin/env python3
import base64
import re
from pathlib import Path

ROOT = Path('/home/ubuntu/P2Server10.4.1-decompiled')
SRC = ROOT / 'decompiled' / 'java'
OUT = ROOT / 'analysis' / 'decoded_strings.md'
call_re = re.compile(r'AbstractC0032a\.m165s\(\s*"((?:\\.|[^"\\])*)"\s*,\s*"((?:\\.|[^"\\])*)"\s*\)')

def java_unescape(s):
    return bytes(s, 'utf-8').decode('unicode_escape').encode('latin1').decode('utf-8', errors='replace')

def decode(a, b):
    a = java_unescape(a).replace('\\n', '\n')
    b = java_unescape(b).replace('\\n', '\n')
    try:
        left = base64.b64decode(a)
        right = base64.b64decode(b)
        out = bytes(x ^ right[i % len(right)] for i, x in enumerate(left))
        return out.decode('utf-8', errors='replace')
    except Exception as e:
        return f'<decode-error:{e}>'

rows = []
for p in sorted(SRC.rglob('*.java')):
    text = p.read_text(errors='replace')
    for m in call_re.finditer(text):
        value = decode(m.group(1), m.group(2))
        line = text.count('\n', 0, m.start()) + 1
        rows.append((str(p.relative_to(ROOT)), line, value))

# Keep all occurrences with source locations, plus an endpoint-focused index.
lines = ['# Strings recuperadas do esquema XOR', '', '> Método: decodificação local das chamadas `AbstractC0032a.m165s`, sem executar o APK.', '', '| Arquivo | Linha | String decodificada |', '|---|---:|---|']
for path, line, value in rows:
    safe = value.replace('|', '\\|').replace('\n', '\\n').replace('\r', '\\r')
    lines.append(f'| `{path}` | {line} | `{safe}` |')
lines += ['', '## Strings relacionadas a rede, autenticação e controle', '', '| Arquivo | Linha | String |', '|---|---:|---|']
keywords = re.compile(r'http|https|ws:|wss:|api|server|broker|auth|token|password|username|mac|playlist|heartbeat|notification|update|login|socket|domain|failover|vod|channel', re.I)
for path, line, value in rows:
    if keywords.search(value):
        safe = value.replace('|', '\\|').replace('\n', '\\n').replace('\r', '\\r')
        lines.append(f'| `{path}` | {line} | `{safe}` |')
lines += ['', f'**Total de ocorrências decodificadas:** {len(rows)}.', '']
OUT.write_text('\n'.join(lines) + '\n')
print(f'{OUT} ({len(rows)} strings)')
