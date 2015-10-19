package com.android.tonyvu.sc.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.tonyvu.sc.demo.adapter.ProductAdapter;
import com.android.tonyvu.sc.demo.constant.Constant;
import com.android.tonyvu.sc.demo.model.Product;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lvProducts = (ListView)findViewById(R.id.lvProducts);
		lvProducts.addHeaderView(getLayoutInflater().inflate(R.layout.product_list_header, lvProducts, false));
		
		ProductAdapter productAdapter = new ProductAdapter(this);
		productAdapter.updateProducts(Constant.PRODUCT_LIST);
		
		lvProducts.setAdapter(productAdapter);
		
		lvProducts.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Product product = Constant.PRODUCT_LIST.get(position-1);
				Intent intent = new Intent(MainActivity.this, ProductActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("product", product);
				Log.d(TAG, "View product: " + product.getName());
				intent.putExtras(bundle);
				startActivity(intent);				
			}
		});
	}
}
