package group.lsg.resultinvestmentapp.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TagChooseFragmentAdapter extends FragmentPagerAdapter {

    private int count;

    public TagChooseFragmentAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return TagChooseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}