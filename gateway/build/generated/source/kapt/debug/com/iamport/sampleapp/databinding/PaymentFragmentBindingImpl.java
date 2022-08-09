package com.iamport.sampleapp.databinding;
import com.iamport.sampleapp.R;
import com.iamport.sampleapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PaymentFragmentBindingImpl extends PaymentFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top, 1);
        sViewsWithIds.put(R.id.back_button, 2);
        sViewsWithIds.put(R.id.user_code_view, 3);
        sViewsWithIds.put(R.id.user_code, 4);
        sViewsWithIds.put(R.id.pg_view, 5);
        sViewsWithIds.put(R.id.pg, 6);
        sViewsWithIds.put(R.id.pg_method_view, 7);
        sViewsWithIds.put(R.id.pg_method, 8);
        sViewsWithIds.put(R.id.name, 9);
        sViewsWithIds.put(R.id.merchant_uid, 10);
        sViewsWithIds.put(R.id.amount, 11);
        sViewsWithIds.put(R.id.card_direct_code, 12);
        sViewsWithIds.put(R.id.cert_parent, 13);
        sViewsWithIds.put(R.id.certification_button, 14);
        sViewsWithIds.put(R.id.mobileweb_mode_button, 15);
        sViewsWithIds.put(R.id.button_parent, 16);
        sViewsWithIds.put(R.id.payment_button, 17);
        sViewsWithIds.put(R.id.webview_mode_button, 18);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PaymentFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private PaymentFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[11]
            , (android.widget.Button) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (android.widget.EditText) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (android.widget.Button) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.EditText) bindings[10]
            , (android.widget.Button) bindings[15]
            , (android.widget.EditText) bindings[9]
            , (android.widget.Button) bindings[17]
            , (android.widget.Spinner) bindings[6]
            , (android.widget.Spinner) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.view.View) bindings[1]
            , (android.widget.Spinner) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.Button) bindings[18]
            );
        this.main.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}