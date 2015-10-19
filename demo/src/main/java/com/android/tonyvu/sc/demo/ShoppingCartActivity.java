package com.android.tonyvu.sc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonyvu.sc.demo.adapter.CartItemAdapter;
import com.android.tonyvu.sc.demo.model.CartItem;
import com.android.tonyvu.sc.demo.model.Product;
import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.model.Saleable;
import com.android.tonyvu.sc.util.CartHelper;

public class ShoppingCartActivity extends Activity {
	
	private static final String TAG = "ShoppingCartActivity";
	
	ListView lvCartItems;
	Button bClear;
	Button bShop;
	TextView tvTotalPrice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		
		lvCartItems = (ListView)findViewById(R.id.lvCartItems);
		LayoutInflater layoutInflater = getLayoutInflater();
		
		final Cart cart = CartHelper.getCart();
		final TextView tvTotalPrice = (TextView)findViewById(R.id.tvTotalPrice);
		tvTotalPrice.setText(String.valueOf(cart.getTotalPrice()));
		
		lvCartItems.addHeaderView(layoutInflater.inflate(R.layout.cart_header, lvCartItems, false));
		
		final CartItemAdapter cartItemAdapter = new CartItemAdapter(this);
		cartItemAdapter.updateCartItems(getCartItems(cart));
		
		lvCartItems.setAdapter(cartItemAdapter);
		
		bClear = (Button)findViewById(R.id.bClear);
		bShop = (Button)findViewById(R.id.bShop);
		
		bClear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "Clearing the shopping cart");
				cart.clear();
				cartItemAdapter.updateCartItems(getCartItems(cart));
				cartItemAdapter.notifyDataSetChanged();
				tvTotalPrice.setText(String.valueOf(cart.getTotalPrice()));
			}
		});
		
		bShop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
    }

	private List<CartItem> getCartItems(Cart cart) {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		Log.d(TAG, "Current shopping cart: " + cart);
		
		Map<Saleable, Integer> itemMap = (Map<Saleable, Integer>)cart.getItemWithQuantity();
		
		for (Entry<Saleable, Integer> entry : itemMap.entrySet()) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct((Product)entry.getKey());
			cartItem.setQuantity(entry.getValue());
			cartItems.add(cartItem);
		}
		
		Log.d(TAG, "Cart item list: " + cartItems);
		return cartItems;
	}

}
