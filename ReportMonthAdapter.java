package group.lsg.resultinvestmentapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import group.lsg.resultinvestmentapp.Class.RinaUtil;
import group.lsg.resultinvestmentapp.R;

public class ReportMonthAdapter extends BaseAdapter {

    private ArrayList<double[]> highestMonthInvestment;
    private int year;

    public ReportMonthAdapter(ArrayList<double[]>
                                      highestMonthInvestment, int year) {
        this.highestMonthInvestment = highestMonthInvestment;
        this.year = year;
    }

    @Override
    public int getCount() {
        return highestMonthInvestment.size() - 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report_month,
                        null);

        TextView icon = (TextView)convertView.findViewById(R.id.month);
        TextView name = (TextView)convertView.findViewById(R.id.month_name);
        TextView expense =
                (TextView)convertView.findViewById(R.id.month_expense);
        TextView records = (TextView)convertView.findViewById(R.id.month_sum);

        icon.setBackgroundResource(getBackgroundResource());
        icon.setText("" + ((int)highestMonthInvestment.get(position +
                1)[1] + 1));
        name.setText(RinaUtil.GetMonthShort((int)
                highestMonthInvestment.get(position + 1)[1] + 1) + " " + year +
                RinaUtil.getInstance().GetPurePercentString(highestMonthInvestment.get(position
                        + 1)[4] * 100));
        expense.setText(RinaUtil.getInstance().GetInMoney((int)
                highestMonthInvestment.get(position + 1)[3]));
        records.setText(RinaUtil.getInstance().GetInRecords((int)
                highestMonthInvestment.get(position + 1)[5]));

        return convertView;
    }

    private int getBackgroundResource() {
        Random random = new Random();
        switch (random.nextInt(6)) {
            case 0: return R.drawable.bg_month_icon_small_0;
            case 1: return R.drawable.bg_month_icon_small_1;
            case 2: return R.drawable.bg_month_icon_small_2;
            case 3: return R.drawable.bg_month_icon_small_3;
            case 4: return R.drawable.bg_month_icon_small_4;
            case 5: return R.drawable.bg_month_icon_small_5;
            default:return R.drawable.bg_month_icon_small_0;
        }
    }

}

