package group.lsg.resultinvestmentapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import group.lsg.resultinvestmentapp.Class.RinaUtil;
import group.lsg.resultinvestmentapp.R;

public class TagChooseGridViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context mContext;
    private int fragmentPosition;
    private int count = 0;

    public TagChooseGridViewAdapter(Context context, int fragmentPosition) {
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
        this.fragmentPosition = fragmentPosition;
    }

    @Override
    public int getCount() {
        if ((fragmentPosition + 1) * 8 >= (RecordManager.TAGS.size() - 2)) {
            return (RecordManager.TAGS.size() - 2) % 8;
        } else {
            return 8;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.item_tag_choose, null);
            holder.tagName = (TextView)convertView.findViewById(R.id.tag_name);
            holder.tagImage =
                    (ImageView)convertView.findViewById(R.id.tag_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tagName.setText(RinaUtil.GetTagName(RecordManager.TAGS.
                get(fragmentPosition * 8 + position + 2).getId()));
        holder.tagName.setTypeface(RinaUtil.typefaceLatoLight);
        holder.tagImage.setImageResource(
                RinaUtil.GetTagIcon(RecordManager.TAGS.
                        get(fragmentPosition * 8 + position + 2).getId()));

        return convertView;
    }

    private class ViewHolder {
        TextView tagName;
        ImageView tagImage;
    }
}
