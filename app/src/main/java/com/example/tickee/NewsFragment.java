package com.example.tickee;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            transaction.remove(fragment);
        }
        transaction.add(R.id.newsContainer, new ItemNew(R.drawable.new1, "30/09/2019", "Ed Sheeran, 'Lọ Lem' Lily James và nhiều sao lớn cùng góp mặt trong phim ca nhạc Yesterday", "Là phim điện ảnh thứ 14 trong sự nghiệp của đạo diễn Triệu Phú Ổ Chuột Danny Boyle."));
        transaction.add(R.id.newsContainer, new ItemNew(R.drawable.new2, "30/09/2019", "Vượt ải kiểm quyệt, Thất Sơn Tâm Linh chính thức tấn công phòng vé Việt", "Dự án điện ảnh Thất Sơn Tâm Linh (tên ban đầu: Thiên Linh Cái) chính thức được Cục Điện Ảnh cấp giấy phép phát hành và ra mắt vào ngày 09.10 sắp tới."));
        transaction.add(R.id.newsContainer, new ItemNew(R.drawable.new3, "30/09/2019", "Siêu phẩm hoạt hình Trung Quốc - Na Tra: Ma Đồng Giáng Thế chính thức đổ bộ phòng chiếu Việt Nam", "Từ đầu tháng 8 năm nay, giới mộ điệu đã xôn xao về một hiện tượng điện ảnh chưa từng có trong lịch sử."));
        transaction.commit();
        return view;
    }

}
