package com.example.projecthk1_2023_2024.databinding;
import com.example.projecthk1_2023_2024.R;
import com.example.projecthk1_2023_2024.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NoticeBoxBindingImpl extends NoticeBoxBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textDesc, 1);
        sViewsWithIds.put(R.id.imageView9, 2);
        sViewsWithIds.put(R.id.textDate, 3);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NoticeBoxBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private NoticeBoxBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.notification == variableId) {
            setNotification((com.example.projecthk1_2023_2024.model.Notification) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNotification(@Nullable com.example.projecthk1_2023_2024.model.Notification Notification) {
        this.mNotification = Notification;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNotification((com.example.projecthk1_2023_2024.model.Notification) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNotification(com.example.projecthk1_2023_2024.model.Notification Notification, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        flag 0 (0x1L): notification
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}