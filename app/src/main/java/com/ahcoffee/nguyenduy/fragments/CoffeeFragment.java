package com.ahcoffee.nguyenduy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahcoffee.nguyenduy.ahcoffee.R;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

public class CoffeeFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.coffee_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      int position = FragmentPagerItem.getPosition(getArguments());
      TextView title = (TextView) view.findViewById(R.id.item_title);
      title.setText(String.valueOf(position));
  }
}
