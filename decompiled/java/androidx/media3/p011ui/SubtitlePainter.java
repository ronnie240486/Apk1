package androidx.media3.p011ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.util.Objects;

final class SubtitlePainter {
    private static final float INNER_PADDING_RATIO = 0.125f;
    private static final String TAG = "SubtitlePainter";
    private int backgroundColor;
    private final Paint bitmapPaint;
    private Rect bitmapRect;
    private float bottomPaddingFraction;
    private Bitmap cueBitmap;
    private float cueBitmapHeight;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private float cueTextSizePx;
    private float defaultTextSizePx;
    private int edgeColor;
    private StaticLayout edgeLayout;
    private int edgeType;
    private int foregroundColor;
    private final float outlineWidth;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint;
    private int textTop;
    private int windowColor;
    private final Paint windowPaint;

    public SubtitlePainter(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.spacingAdd = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.spacingMult = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.outlineWidth = fRound;
        this.shadowRadius = fRound;
        this.shadowOffset = fRound;
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.windowPaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.bitmapPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean areCharSequencesEqual(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void drawBitmapLayout(Canvas canvas) {
        canvas.drawBitmap(this.cueBitmap, (Rect) null, this.bitmapRect, this.bitmapPaint);
    }

    private void drawLayout(Canvas canvas, boolean z7) {
        if (z7) {
            drawTextLayout(canvas);
            return;
        }
        Assertions.checkNotNull(this.bitmapRect);
        Assertions.checkNotNull(this.cueBitmap);
        drawBitmapLayout(canvas);
    }

    private void drawTextLayout(Canvas canvas) {
        StaticLayout staticLayout = this.textLayout;
        StaticLayout staticLayout2 = this.edgeLayout;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.textLeft, this.textTop);
        if (Color.alpha(this.windowColor) > 0) {
            this.windowPaint.setColor(this.windowColor);
            canvas.drawRect(-this.textPaddingX, 0.0f, staticLayout.getWidth() + this.textPaddingX, staticLayout.getHeight(), this.windowPaint);
        }
        int i6 = this.edgeType;
        if (i6 == 1) {
            this.textPaint.setStrokeJoin(Paint.Join.ROUND);
            this.textPaint.setStrokeWidth(this.outlineWidth);
            this.textPaint.setColor(this.edgeColor);
            this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i6 == 2) {
            TextPaint textPaint = this.textPaint;
            float f = this.shadowRadius;
            float f3 = this.shadowOffset;
            textPaint.setShadowLayer(f, f3, f3, this.edgeColor);
        } else if (i6 == 3 || i6 == 4) {
            boolean z7 = i6 == 3;
            int i10 = z7 ? -1 : this.edgeColor;
            int i11 = z7 ? this.edgeColor : -1;
            float f4 = this.shadowRadius / 2.0f;
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            float f5 = -f4;
            this.textPaint.setShadowLayer(this.shadowRadius, f5, f5, i10);
            staticLayout2.draw(canvas);
            this.textPaint.setShadowLayer(this.shadowRadius, f4, f4, i11);
        }
        this.textPaint.setColor(this.foregroundColor);
        this.textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    private void setupBitmapLayout() {
        int iRound;
        float f;
        int i6;
        float f3;
        Bitmap bitmap = this.cueBitmap;
        int i10 = this.parentRight;
        int i11 = this.parentLeft;
        int i12 = this.parentBottom;
        int i13 = this.parentTop;
        float f4 = i10 - i11;
        float f5 = (this.cuePosition * f4) + i11;
        float f10 = i12 - i13;
        float f11 = (this.cueLine * f10) + i13;
        int iRound2 = Math.round(f4 * this.cueSize);
        float f12 = this.cueBitmapHeight;
        if (f12 != -3.4028235E38f) {
            iRound = Math.round(f10 * f12);
        } else {
            iRound = Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound2);
        }
        int i14 = this.cuePositionAnchor;
        if (i14 != 2) {
            if (i14 == 1) {
                f = iRound2 / 2;
            }
            int iRound3 = Math.round(f5);
            i6 = this.cueLineAnchor;
            if (i6 == 2) {
                if (i6 == 1) {
                    f3 = iRound / 2;
                }
                int iRound4 = Math.round(f11);
                this.bitmapRect = new Rect(iRound3, iRound4, iRound2 + iRound3, iRound + iRound4);
            }
            f3 = iRound;
            f11 -= f3;
            int iRound5 = Math.round(f11);
            this.bitmapRect = new Rect(iRound3, iRound5, iRound2 + iRound3, iRound + iRound5);
        }
        f = iRound2;
        f5 -= f;
        int iRound6 = Math.round(f5);
        i6 = this.cueLineAnchor;
        if (i6 == 2) {
            if (i6 == 1) {
                f3 = iRound / 2;
            }
            int iRound7 = Math.round(f11);
            this.bitmapRect = new Rect(iRound6, iRound7, iRound2 + iRound6, iRound + iRound7);
        }
        f3 = iRound;
        f11 -= f3;
        int iRound8 = Math.round(f11);
        this.bitmapRect = new Rect(iRound6, iRound8, iRound2 + iRound6, iRound + iRound8);
    }

    private void setupTextLayout() {
        int i6;
        int i10;
        int iMax;
        int iMin;
        int iRound;
        int i11;
        CharSequence charSequence = this.cueText;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.cueText);
        int i12 = this.parentRight - this.parentLeft;
        int i13 = this.parentBottom - this.parentTop;
        this.textPaint.setTextSize(this.defaultTextSizePx);
        int i14 = (int) ((this.defaultTextSizePx * INNER_PADDING_RATIO) + 0.5f);
        int i15 = i14 * 2;
        int i16 = i12 - i15;
        float f = this.cueSize;
        if (f != -3.4028235E38f) {
            i16 = (int) (i16 * f);
        }
        int i17 = i16;
        if (i17 <= 0) {
            Log.m1719w(TAG, "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.cueTextSizePx > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.cueTextSizePx), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.edgeType == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.backgroundColor) > 0) {
            int i18 = this.edgeType;
            if (i18 == 0 || i18 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.cueTextAlignment;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i17, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLayout = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.textLayout.getLineCount();
        int iMax2 = 0;
        for (int i19 = 0; i19 < lineCount; i19++) {
            iMax2 = Math.max((int) Math.ceil(this.textLayout.getLineWidth(i19)), iMax2);
        }
        if (this.cueSize == -3.4028235E38f || iMax2 >= i17) {
            i17 = iMax2;
        }
        int i20 = i17 + i15;
        float f3 = this.cuePosition;
        if (f3 != -3.4028235E38f) {
            int iRound2 = Math.round(i12 * f3);
            int i21 = this.parentLeft;
            int i22 = iRound2 + i21;
            int i23 = this.cuePositionAnchor;
            i6 = 1;
            if (i23 != 1) {
                i10 = 2;
                if (i23 == 2) {
                    i22 -= i20;
                }
            } else {
                i10 = 2;
                i22 = ((i22 * 2) - i20) / 2;
            }
            iMax = Math.max(i22, i21);
            iMin = Math.min(i20 + iMax, this.parentRight);
        } else {
            i6 = 1;
            i10 = 2;
            iMax = ((i12 - i20) / 2) + this.parentLeft;
            iMin = iMax + i20;
        }
        int i24 = iMin - iMax;
        if (i24 <= 0) {
            Log.m1719w(TAG, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f4 = this.cueLine;
        if (f4 != -3.4028235E38f) {
            if (this.cueLineType == 0) {
                iRound = Math.round(i13 * f4) + this.parentTop;
                int i25 = this.cueLineAnchor;
                if (i25 == i10) {
                    iRound -= height;
                } else if (i25 == i6) {
                    iRound = ((iRound * 2) - height) / i10;
                }
            } else {
                int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                float f5 = this.cueLine;
                if (f5 >= 0.0f) {
                    iRound = Math.round(f5 * lineBottom) + this.parentTop;
                } else {
                    iRound = Math.round((f5 + 1.0f) * lineBottom) + this.parentBottom;
                    iRound -= height;
                }
            }
            int i26 = iRound + height;
            int i27 = this.parentBottom;
            if (i26 <= i27) {
                int i28 = this.parentTop;
                if (iRound < i28) {
                    i11 = i28;
                }
                this.textLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i24, alignment2, this.spacingMult, this.spacingAdd, true);
                this.edgeLayout = new StaticLayout(spannableStringBuilder2, this.textPaint, i24, alignment2, this.spacingMult, this.spacingAdd, true);
                this.textLeft = iMax;
                this.textTop = i11;
                this.textPaddingX = i14;
            }
            iRound = i27 - height;
        } else {
            iRound = (this.parentBottom - height) - ((int) (i13 * this.bottomPaddingFraction));
        }
        i11 = iRound;
        this.textLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i24, alignment2, this.spacingMult, this.spacingAdd, true);
        this.edgeLayout = new StaticLayout(spannableStringBuilder2, this.textPaint, i24, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLeft = iMax;
        this.textTop = i11;
        this.textPaddingX = i14;
    }

    public void draw(Cue cue, CaptionStyleCompat captionStyleCompat, float f, float f3, float f4, Canvas canvas, int i6, int i10, int i11, int i12) {
        int i13;
        boolean z7 = cue.bitmap == null;
        if (!z7) {
            i13 = -16777216;
        } else if (TextUtils.isEmpty(cue.text)) {
            return;
        } else {
            i13 = cue.windowColorSet ? cue.windowColor : captionStyleCompat.windowColor;
        }
        if (areCharSequencesEqual(this.cueText, cue.text) && Objects.equals(this.cueTextAlignment, cue.textAlignment) && this.cueBitmap == cue.bitmap && this.cueLine == cue.line && this.cueLineType == cue.lineType && Integer.valueOf(this.cueLineAnchor).equals(Integer.valueOf(cue.lineAnchor)) && this.cuePosition == cue.position && Integer.valueOf(this.cuePositionAnchor).equals(Integer.valueOf(cue.positionAnchor)) && this.cueSize == cue.size && this.cueBitmapHeight == cue.bitmapHeight && this.foregroundColor == captionStyleCompat.foregroundColor && this.backgroundColor == captionStyleCompat.backgroundColor && this.windowColor == i13 && this.edgeType == captionStyleCompat.edgeType && this.edgeColor == captionStyleCompat.edgeColor && Objects.equals(this.textPaint.getTypeface(), captionStyleCompat.typeface) && this.defaultTextSizePx == f && this.cueTextSizePx == f3 && this.bottomPaddingFraction == f4 && this.parentLeft == i6 && this.parentTop == i10 && this.parentRight == i11 && this.parentBottom == i12) {
            drawLayout(canvas, z7);
            return;
        }
        this.cueText = cue.text;
        this.cueTextAlignment = cue.textAlignment;
        this.cueBitmap = cue.bitmap;
        this.cueLine = cue.line;
        this.cueLineType = cue.lineType;
        this.cueLineAnchor = cue.lineAnchor;
        this.cuePosition = cue.position;
        this.cuePositionAnchor = cue.positionAnchor;
        this.cueSize = cue.size;
        this.cueBitmapHeight = cue.bitmapHeight;
        this.foregroundColor = captionStyleCompat.foregroundColor;
        this.backgroundColor = captionStyleCompat.backgroundColor;
        this.windowColor = i13;
        this.edgeType = captionStyleCompat.edgeType;
        this.edgeColor = captionStyleCompat.edgeColor;
        this.textPaint.setTypeface(captionStyleCompat.typeface);
        this.defaultTextSizePx = f;
        this.cueTextSizePx = f3;
        this.bottomPaddingFraction = f4;
        this.parentLeft = i6;
        this.parentTop = i10;
        this.parentRight = i11;
        this.parentBottom = i12;
        if (z7) {
            Assertions.checkNotNull(this.cueText);
            setupTextLayout();
        } else {
            Assertions.checkNotNull(this.cueBitmap);
            setupBitmapLayout();
        }
        drawLayout(canvas, z7);
    }
}
