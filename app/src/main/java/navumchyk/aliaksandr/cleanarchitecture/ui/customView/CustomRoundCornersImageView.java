package navumchyk.aliaksandr.cleanarchitecture.ui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * @author Aliaksandr Navumchyk
 */
public class CustomRoundCornersImageView extends AppCompatImageView {

    private final static float RADIUS_MOD = 10f;
    private float mRadius;

    public CustomRoundCornersImageView(Context context) {
        super(context);
        mRadius = context.getResources().getDisplayMetrics().density * RADIUS_MOD;
    }

    public CustomRoundCornersImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRadius = context.getResources().getDisplayMetrics().density * RADIUS_MOD;
    }

    public CustomRoundCornersImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mRadius = context.getResources().getDisplayMetrics().density * RADIUS_MOD;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final Path clipPath = new Path();
        final RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, mRadius, mRadius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
