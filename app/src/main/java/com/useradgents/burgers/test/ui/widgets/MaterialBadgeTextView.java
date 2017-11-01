package com.useradgents.burgers.test.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.sample.github.R;

public class MaterialBadgeTextView extends TextView {

    private static final int DEFAULT_FILL_TYPE = 0;

    private int backgroundColor;
    private int borderColor;
    private float borderWidth;
    private float borderAlpha;
    private int ctType;

    private static final float SHADOW_RADIUS = 3.5f;
    private static final int FILL_SHADOW_COLOR = 0x55000000;
    private static final int KEY_SHADOW_COLOR = 0x55000000;

    private static final float X_OFFSET = 0f;
    private static final float Y_OFFSET = 1.75f;


    private float density;
    private int mShadowRadius;
    private int shadowYOffset;
    private int shadowXOffset;

    private int basePadding;
    private int diffWH;

    private boolean isHighLightMode;

    public MaterialBadgeTextView(final Context context) {
        this(context, null);
    }

    public MaterialBadgeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialBadgeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setGravity(Gravity.CENTER);
        density = getContext().getResources().getDisplayMetrics().density;
        mShadowRadius = (int) (density * SHADOW_RADIUS);
        shadowYOffset = (int) (density * Y_OFFSET);
        shadowXOffset = (int) (density * X_OFFSET);
        basePadding = (mShadowRadius * 2);
        float textHeight = getTextSize();
        float textWidth = textHeight / 4;
        diffWH = (int) (Math.abs(textHeight - textWidth) / 2);
        int horizontalPadding = basePadding + diffWH;
        setPadding(horizontalPadding, basePadding, horizontalPadding, basePadding);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialBadgeTextView);
        backgroundColor = typedArray.getColor(R.styleable.MaterialBadgeTextView_mbtv_backgroundColor, Color.WHITE);
        borderColor = typedArray.getColor(R.styleable.MaterialBadgeTextView_mbtv_border_color, Color.TRANSPARENT);
        borderWidth = typedArray.getDimension(R.styleable.MaterialBadgeTextView_mbtv_border_width, 0);
        borderAlpha = typedArray.getFloat(R.styleable.MaterialBadgeTextView_mbtv_border_alpha, 1);
        ctType = typedArray.getInt(R.styleable.MaterialBadgeTextView_mbtv_type, DEFAULT_FILL_TYPE);
        typedArray.recycle();
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        String strText = text==null?"":text.toString().trim();
        if(isHighLightMode && !"".equals(strText)){
            ViewGroup.LayoutParams lp = getLayoutParams();
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            setLayoutParams(lp);
            isHighLightMode = false;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        refreshBackgroundDrawable(w, h);
    }

    private void refreshBackgroundDrawable(int targetWidth, int targetHeight) {
        if (targetWidth <= 0 || targetHeight <= 0) {
            return;
        }
        CharSequence text = getText();
        if (text == null) {
            return;
        }
        if (text.length() == 1) {
            int max = Math.max(targetWidth, targetHeight);
            ShapeDrawable circle;
            final int diameter = max - (2 * mShadowRadius);
            OvalShape oval = new OvalShadow(mShadowRadius, diameter);
            circle = new ShapeDrawable(oval);
            ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, circle.getPaint());
            circle.getPaint().setShadowLayer(mShadowRadius, shadowXOffset, shadowYOffset, KEY_SHADOW_COLOR);
            circle.getPaint().setColor(backgroundColor);
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
                setBackgroundDrawable(circle);
            } else {
                setBackground(circle);
            }
        } else if (text.length() > 1) {
            SemiCircleRectDrawable sr = new SemiCircleRectDrawable();
            ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, sr.getPaint());
            sr.getPaint().setShadowLayer(mShadowRadius, shadowXOffset, shadowYOffset, KEY_SHADOW_COLOR);
            sr.getPaint().setColor(backgroundColor);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                setBackground(sr);
            } else {
                setBackgroundDrawable(sr);
            }
        }
    }



    public void setBackgroundColor(int color){
        backgroundColor = color;
        refreshBackgroundDrawable(getWidth(), getHeight());
    }

    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        private int mCircleDiameter;

        public OvalShadow(int shadowRadius, int circleDiameter) {
            super();
            mShadowPaint = new Paint();
            mShadowRadius = shadowRadius;
            mCircleDiameter = circleDiameter;
            mRadialGradient = new RadialGradient(mCircleDiameter / 2, mCircleDiameter / 2,
                    mShadowRadius, new int[]{
                    FILL_SHADOW_COLOR, Color.TRANSPARENT
            }, null, Shader.TileMode.CLAMP);
            mShadowPaint.setShader(mRadialGradient);
        }

        @Override
        public void draw(Canvas canvas, Paint paint) {
            final int viewWidth = MaterialBadgeTextView.this.getWidth();
            final int viewHeight = MaterialBadgeTextView.this.getHeight();
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, (mCircleDiameter / 2 + mShadowRadius), mShadowPaint);
            canvas.drawCircle(viewWidth / 2, viewHeight / 2, (mCircleDiameter / 2), paint);
        }
    }

    class SemiCircleRectDrawable extends Drawable {
        private final Paint mPaint;
        private RectF rectF;

        public Paint getPaint() {
            return mPaint;
        }

        public SemiCircleRectDrawable() {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }

        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            super.setBounds(left, top, right, bottom);
            if (rectF == null) {
                rectF = new RectF(left + diffWH, top + mShadowRadius+4, right - diffWH, bottom - mShadowRadius-4);
            } else {
                rectF.set(left + diffWH, top + mShadowRadius+4, right - diffWH, bottom - mShadowRadius-4);
            }
        }

        @Override
        public void draw(Canvas canvas) {
            float R = (float)(rectF.bottom * 0.4);
            if (rectF.right < rectF.bottom) {
                R = (float)(rectF.right * 0.4);
            }
            canvas.drawRoundRect(rectF, R, R, mPaint);
        }

        @Override
        public void setAlpha(int alpha) {
            mPaint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            mPaint.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSPARENT;
        }
    }

}
