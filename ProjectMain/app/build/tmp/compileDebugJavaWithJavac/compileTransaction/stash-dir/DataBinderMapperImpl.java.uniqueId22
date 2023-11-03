package com.example.projecthk1_2023_2024;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.projecthk1_2023_2024.databinding.AdminHomeBindingImpl;
import com.example.projecthk1_2023_2024.databinding.NoticeBoxBindingImpl;
import com.example.projecthk1_2023_2024.databinding.NvkhoFragHomeLayoutBindingImpl;
import com.example.projecthk1_2023_2024.databinding.ViewholderNotificationBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ADMINHOME = 1;

  private static final int LAYOUT_NOTICEBOX = 2;

  private static final int LAYOUT_NVKHOFRAGHOMELAYOUT = 3;

  private static final int LAYOUT_VIEWHOLDERNOTIFICATION = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projecthk1_2023_2024.R.layout.admin_home, LAYOUT_ADMINHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projecthk1_2023_2024.R.layout.notice_box, LAYOUT_NOTICEBOX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projecthk1_2023_2024.R.layout.nvkho_frag_home_layout, LAYOUT_NVKHOFRAGHOMELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projecthk1_2023_2024.R.layout.viewholder_notification, LAYOUT_VIEWHOLDERNOTIFICATION);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ADMINHOME: {
          if ("layout/admin_home_0".equals(tag)) {
            return new AdminHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for admin_home is invalid. Received: " + tag);
        }
        case  LAYOUT_NOTICEBOX: {
          if ("layout/notice_box_0".equals(tag)) {
            return new NoticeBoxBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for notice_box is invalid. Received: " + tag);
        }
        case  LAYOUT_NVKHOFRAGHOMELAYOUT: {
          if ("layout/nvkho_frag_home_layout_0".equals(tag)) {
            return new NvkhoFragHomeLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for nvkho_frag_home_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWHOLDERNOTIFICATION: {
          if ("layout/viewholder_notification_0".equals(tag)) {
            return new ViewholderNotificationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for viewholder_notification is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(20);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "account");
      sKeys.put(2, "address");
      sKeys.put(3, "birthday");
      sKeys.put(4, "date_Create");
      sKeys.put(5, "description");
      sKeys.put(6, "email");
      sKeys.put(7, "enable");
      sKeys.put(8, "iDBatch");
      sKeys.put(9, "iDExport");
      sKeys.put(10, "iDImport");
      sKeys.put(11, "image");
      sKeys.put(12, "loginId");
      sKeys.put(13, "name");
      sKeys.put(14, "notification");
      sKeys.put(15, "phone");
      sKeys.put(16, "postCode");
      sKeys.put(17, "role");
      sKeys.put(18, "sex");
      sKeys.put(19, "start_Date");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/admin_home_0", com.example.projecthk1_2023_2024.R.layout.admin_home);
      sKeys.put("layout/notice_box_0", com.example.projecthk1_2023_2024.R.layout.notice_box);
      sKeys.put("layout/nvkho_frag_home_layout_0", com.example.projecthk1_2023_2024.R.layout.nvkho_frag_home_layout);
      sKeys.put("layout/viewholder_notification_0", com.example.projecthk1_2023_2024.R.layout.viewholder_notification);
    }
  }
}
