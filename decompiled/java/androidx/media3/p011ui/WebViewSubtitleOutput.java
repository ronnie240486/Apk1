package androidx.media3.p011ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    private static final float CSS_LINE_HEIGHT = 1.2f;
    private static final String DEFAULT_BACKGROUND_CSS_CLASS = "default_bg";
    private float bottomPaddingFraction;
    private final CanvasSubtitleOutput canvasSubtitleOutput;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private CaptionStyleCompat style;
    private List<Cue> textCues;
    private final WebView webView;

    public static class C10552 {
        static final int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    private static int anchorTypeToTranslatePercent(int i6) {
        if (i6 != 1) {
            return i6 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i6 = C10552.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i6 != 1) {
            return i6 != 2 ? TtmlNode.CENTER : TtmlNode.END;
        }
        return TtmlNode.START;
    }

    private static String convertCaptionStyleToCssTextShadow(CaptionStyleCompat captionStyleCompat) {
        int i6 = captionStyleCompat.edgeType;
        if (i6 == 1) {
            return Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        if (i6 == 2) {
            return Util.formatInvariant("0.1em 0.12em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        if (i6 != 3) {
            return i6 != 4 ? "unset" : Util.formatInvariant("-0.05em -0.05em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        return Util.formatInvariant("0.06em 0.08em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
    }

    private String convertTextSizeToCss(int i6, float f) {
        float fResolveTextSize = SubtitleViewUtils.resolveTextSize(i6, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fResolveTextSize == -3.4028235E38f ? "unset" : Util.formatInvariant("%.2fpx", Float.valueOf(fResolveTextSize / getContext().getResources().getDisplayMetrics().density));
    }

    private static String convertVerticalTypeToCss(int i6) {
        if (i6 != 1) {
            return i6 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    private static String getBlockShearTransformFunction(Cue cue) {
        float f = cue.shearDegrees;
        if (f == 0.0f) {
            return "";
        }
        int i6 = cue.verticalType;
        return Util.formatInvariant("%s(%.2fdeg)", (i6 == 2 || i6 == 1) ? "skewY" : "skewX", Float.valueOf(f));
    }

    private void updateWebView() {
        String invariant;
        int iAnchorTypeToTranslatePercent;
        boolean z7;
        float f;
        String invariant2;
        int i6;
        int i10;
        int i11;
        String str;
        String str2;
        String str3;
        int i12;
        SpannedToHtmlConverter.HtmlAndCss htmlAndCssConvert;
        Iterator it;
        SpannedToHtmlConverter.HtmlAndCss htmlAndCss;
        Layout.Alignment alignment;
        String str4;
        boolean z10;
        WebViewSubtitleOutput webViewSubtitleOutput = this;
        StringBuilder sb = new StringBuilder();
        String cssRgba = HtmlUtils.toCssRgba(webViewSubtitleOutput.style.foregroundColor);
        String strConvertTextSizeToCss = webViewSubtitleOutput.convertTextSizeToCss(webViewSubtitleOutput.defaultTextSizeType, webViewSubtitleOutput.defaultTextSize);
        float f3 = CSS_LINE_HEIGHT;
        char c5 = 0;
        int i13 = 1;
        sb.append(Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", cssRgba, strConvertTextSizeToCss, Float.valueOf(CSS_LINE_HEIGHT), convertCaptionStyleToCssTextShadow(webViewSubtitleOutput.style)));
        HashMap map = new HashMap();
        map.put(HtmlUtils.cssAllClassDescendantsSelector(DEFAULT_BACKGROUND_CSS_CLASS), Util.formatInvariant("background-color:%s;", HtmlUtils.toCssRgba(webViewSubtitleOutput.style.backgroundColor)));
        int i14 = 0;
        while (i14 < webViewSubtitleOutput.textCues.size()) {
            Cue cue = webViewSubtitleOutput.textCues.get(i14);
            float f4 = cue.position;
            float f5 = f4 != -3.4028235E38f ? f4 * 100.0f : 50.0f;
            int iAnchorTypeToTranslatePercent2 = anchorTypeToTranslatePercent(cue.positionAnchor);
            float f10 = cue.line;
            if (f10 == -3.4028235E38f) {
                Object[] objArr = new Object[i13];
                objArr[c5] = Float.valueOf((1.0f - webViewSubtitleOutput.bottomPaddingFraction) * 100.0f);
                invariant = Util.formatInvariant("%.2f%%", objArr);
                iAnchorTypeToTranslatePercent = -100;
            } else if (cue.lineType != i13) {
                Float fValueOf = Float.valueOf(f10 * 100.0f);
                Object[] objArr2 = new Object[i13];
                objArr2[c5] = fValueOf;
                invariant = Util.formatInvariant("%.2f%%", objArr2);
                iAnchorTypeToTranslatePercent = cue.verticalType == i13 ? -anchorTypeToTranslatePercent(cue.lineAnchor) : anchorTypeToTranslatePercent(cue.lineAnchor);
            } else {
                if (f10 >= 0.0f) {
                    Float fValueOf2 = Float.valueOf(f10 * f3);
                    Object[] objArr3 = new Object[i13];
                    objArr3[c5] = fValueOf2;
                    invariant = Util.formatInvariant("%.2fem", objArr3);
                    iAnchorTypeToTranslatePercent = 0;
                } else {
                    Float fValueOf3 = Float.valueOf(((-f10) - 1.0f) * f3);
                    Object[] objArr4 = new Object[i13];
                    objArr4[c5] = fValueOf3;
                    invariant = Util.formatInvariant("%.2fem", objArr4);
                    iAnchorTypeToTranslatePercent = 0;
                    z7 = true;
                }
                f = cue.size;
                if (f != -3.4028235E38f) {
                    Object[] objArr5 = new Object[i13];
                    objArr5[c5] = Float.valueOf(f * 100.0f);
                    invariant2 = Util.formatInvariant("%.2f%%", objArr5);
                } else {
                    invariant2 = "fit-content";
                }
                String strConvertAlignmentToCss = convertAlignmentToCss(cue.textAlignment);
                String strConvertVerticalTypeToCss = convertVerticalTypeToCss(cue.verticalType);
                String strConvertTextSizeToCss2 = webViewSubtitleOutput.convertTextSizeToCss(cue.textSizeType, cue.textSize);
                if (cue.windowColorSet) {
                    i6 = cue.windowColor;
                } else {
                    i6 = webViewSubtitleOutput.style.windowColor;
                }
                String cssRgba2 = HtmlUtils.toCssRgba(i6);
                i10 = iAnchorTypeToTranslatePercent;
                i11 = cue.verticalType;
                str = TtmlNode.RIGHT;
                str2 = "top";
                if (i11 != 1) {
                    if (i11 != 2) {
                        str = z7 ? "bottom" : "top";
                        str2 = TtmlNode.LEFT;
                    } else if (!z7) {
                        str = TtmlNode.LEFT;
                    }
                } else if (z7) {
                    str = TtmlNode.LEFT;
                }
                if (i11 != 2 || i11 == 1) {
                    str3 = "height";
                    i12 = i10;
                    i10 = iAnchorTypeToTranslatePercent2;
                } else {
                    str3 = "width";
                    i12 = iAnchorTypeToTranslatePercent2;
                }
                htmlAndCssConvert = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str5 = (String) it.next();
                    SpannedToHtmlConverter.HtmlAndCss htmlAndCss2 = htmlAndCssConvert;
                    str4 = (String) map.put(str5, (String) map.get(str5));
                    if (str4 != null || str4.equals(map.get(str5))) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Assertions.checkState(z10);
                    it = it2;
                    htmlAndCssConvert = htmlAndCss2;
                }
                htmlAndCss = htmlAndCssConvert;
                HashMap map2 = map;
                sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i14), str2, Float.valueOf(f5), str, invariant, str3, invariant2, strConvertAlignmentToCss, strConvertVerticalTypeToCss, strConvertTextSizeToCss2, cssRgba2, Integer.valueOf(i12), Integer.valueOf(i10), getBlockShearTransformFunction(cue)));
                sb.append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
                alignment = cue.multiRowAlignment;
                if (alignment != null) {
                    sb.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", convertAlignmentToCss(alignment)));
                    sb.append(htmlAndCss.html);
                    sb.append("</span>");
                } else {
                    sb.append(htmlAndCss.html);
                }
                sb.append("</span></div>");
                i13 = 1;
                i14++;
                f3 = CSS_LINE_HEIGHT;
                c5 = 0;
                webViewSubtitleOutput = this;
                map = map2;
            }
            z7 = false;
            f = cue.size;
            if (f != -3.4028235E38f) {
                Object[] objArr6 = new Object[i13];
                objArr6[c5] = Float.valueOf(f * 100.0f);
                invariant2 = Util.formatInvariant("%.2f%%", objArr6);
            } else {
                invariant2 = "fit-content";
            }
            String strConvertAlignmentToCss2 = convertAlignmentToCss(cue.textAlignment);
            String strConvertVerticalTypeToCss2 = convertVerticalTypeToCss(cue.verticalType);
            String strConvertTextSizeToCss3 = webViewSubtitleOutput.convertTextSizeToCss(cue.textSizeType, cue.textSize);
            if (cue.windowColorSet) {
                i6 = cue.windowColor;
            } else {
                i6 = webViewSubtitleOutput.style.windowColor;
            }
            String cssRgba3 = HtmlUtils.toCssRgba(i6);
            i10 = iAnchorTypeToTranslatePercent;
            i11 = cue.verticalType;
            str = TtmlNode.RIGHT;
            str2 = "top";
            if (i11 != 1) {
                if (i11 != 2) {
                    str = z7 ? "bottom" : "top";
                    str2 = TtmlNode.LEFT;
                } else if (!z7) {
                    str = TtmlNode.LEFT;
                }
            } else if (z7) {
                str = TtmlNode.LEFT;
            }
            if (i11 != 2) {
                str3 = "height";
                i12 = i10;
                i10 = iAnchorTypeToTranslatePercent2;
            } else {
                str3 = "height";
                i12 = i10;
                i10 = iAnchorTypeToTranslatePercent2;
            }
            htmlAndCssConvert = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str6 = (String) it.next();
                SpannedToHtmlConverter.HtmlAndCss htmlAndCss3 = htmlAndCssConvert;
                str4 = (String) map.put(str6, (String) map.get(str6));
                if (str4 != null) {
                    z10 = true;
                } else {
                    z10 = true;
                }
                Assertions.checkState(z10);
                it = it3;
                htmlAndCssConvert = htmlAndCss3;
            }
            htmlAndCss = htmlAndCssConvert;
            HashMap map3 = map;
            sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i14), str2, Float.valueOf(f5), str, invariant, str3, invariant2, strConvertAlignmentToCss2, strConvertVerticalTypeToCss2, strConvertTextSizeToCss3, cssRgba3, Integer.valueOf(i12), Integer.valueOf(i10), getBlockShearTransformFunction(cue)));
            sb.append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
            alignment = cue.multiRowAlignment;
            if (alignment != null) {
                sb.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", convertAlignmentToCss(alignment)));
                sb.append(htmlAndCss.html);
                sb.append("</span>");
            } else {
                sb.append(htmlAndCss.html);
            }
            sb.append("</span></div>");
            i13 = 1;
            i14++;
            f3 = CSS_LINE_HEIGHT;
            c5 = 0;
            webViewSubtitleOutput = this;
            map = map3;
        }
        HashMap map4 = map;
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder("<html><head><style>");
        for (String str7 : map4.keySet()) {
            sb2.append(str7);
            sb2.append("{");
            sb2.append((String) map4.get(str7));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.webView.loadData(Base64.encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8), 1), "text/html", "base64");
    }

    public void destroy() {
        this.webView.destroy();
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        if (!z7 || this.textCues.isEmpty()) {
            return;
        }
        updateWebView();
    }

    @Override
    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i6, float f3) {
        this.style = captionStyleCompat;
        this.defaultTextSize = f;
        this.defaultTextSizeType = i6;
        this.bottomPaddingFraction = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Cue cue = list.get(i10);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.textCues.isEmpty() || !arrayList2.isEmpty()) {
            this.textCues = arrayList2;
            updateWebView();
        }
        this.canvasSubtitleOutput.update(arrayList, captionStyleCompat, f, i6, f3);
        invalidate();
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textCues = Collections.emptyList();
        this.style = CaptionStyleCompat.DEFAULT;
        this.defaultTextSize = 0.0533f;
        this.defaultTextSizeType = 0;
        this.bottomPaddingFraction = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.canvasSubtitleOutput = canvasSubtitleOutput;
        WebView webView = new WebView(context, attributeSet) {
            @Override
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            @Override
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = webView;
        webView.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webView);
    }
}
