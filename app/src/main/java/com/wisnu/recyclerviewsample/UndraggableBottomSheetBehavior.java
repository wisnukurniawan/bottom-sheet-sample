package com.wisnu.recyclerviewsample;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wisnu on 01/08/2017.
 */

public class UndraggableBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    private Boolean allowDragging = true;

    /**
     * Default constructor
     */
    UndraggableBottomSheetBehavior() {
        super();
    }

    UndraggableBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Boolean getAllowDragging() {
        return allowDragging;
    }

    public void setAllowDragging(Boolean allowDragging) {
        this.allowDragging = allowDragging;
    }

    public void setBehaviorToView(View view) {
        CoordinatorLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        layoutParams.setBehavior(this);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!allowDragging) {
            return false;
        }

        return super.onInterceptTouchEvent(parent, child, event);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!allowDragging) {
            return false;
        }

        return super.onTouchEvent(parent, child, event);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes) {
        if (!allowDragging) {
            return false;
        }

        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        if (!allowDragging) {
            return false;
        }

        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed) {
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    }

}
