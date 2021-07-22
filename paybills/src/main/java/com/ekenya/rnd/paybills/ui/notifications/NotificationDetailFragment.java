package com.ekenya.rnd.paybills.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ekenya.rnd.common.abstractions.BaseDaggerFragment;
import com.ekenya.rnd.paybills.R;
import com.ekenya.rnd.paybills.databinding.FragmentNotificationDetailBinding;
import com.ekenya.rnd.paybills.ui.notifications.placeholder.PlaceholderContent;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * A fragment representing a single AccountItem detail screen.
 * This fragment is either contained in a {@link AccountItemListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class NotificationDetailFragment extends BaseDaggerFragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The placeholder content this fragment is presenting.
     */
    private PlaceholderContent.PlaceholderItem mItem;
    private FragmentNotificationDetailBinding binding;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotificationDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the placeholder content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNotificationDetailBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        CollapsingToolbarLayout toolbarLayout = rootView.findViewById(R.id.toolbar_layout);

        // Show the placeholder content as text in a TextView & in the toolbar if available.
        if (mItem != null) {
            TextView textView = binding.notificationDetail;
            textView.setText(mItem.details);
            if (toolbarLayout != null) {
                toolbarLayout.setTitle(mItem.content);
            }
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}