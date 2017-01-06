package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhang on 2016/12/30.
 */

public class Circe extends View {
    public Circe(Context context) {
        super(context);
    }
    public void addrest(int max,int current){
        this.max = max;
        this.current = current;
        postInvalidate();

        //主线程
        //invalidate();
    }
    public Circe(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Circe(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    Paint paint;
    Paint cpaint;
    Paint percentpaint;
    int max=360;
    int current;
    float textSize=20;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(getWidth()== 0 || getHeight() == 0){

            return;
        }

        Circle(canvas);
    }
    public void Circle(Canvas canvas){

        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        cpaint=new Paint();
        cpaint.setColor(Color.RED);
        cpaint.setStrokeWidth(5);
        cpaint.setAntiAlias(true);
        cpaint.setStyle(Paint.Style.STROKE);

        percentpaint=new Paint();
        percentpaint.setTextSize(textSize);
        percentpaint.setStrokeWidth(2);
        percentpaint.setColor(Color.BLACK);

        int center=getWidth()/2;
        int radio=(getWidth()-20)/2;

        canvas.drawCircle(getWidth()/2,getHeight()/2,radio,paint);
        RectF rect=new RectF(center-radio,getHeight()/2-radio,center+radio,getHeight()/2+radio);
        canvas.drawArc(rect,0,360*current/max,false,cpaint);

        int perent=(int)((current*1.0/max*1.0)*100);
        float textWidth = paint.measureText(perent + "%");

        canvas.drawText(perent+"%",center-textWidth/2,center+textSize/2,percentpaint);
    }
}
