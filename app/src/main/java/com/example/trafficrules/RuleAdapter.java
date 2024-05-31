package com.example.trafficrules;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.RuleViewHolder> {
    private List<Rule> rulesList;

    public RuleAdapter(List<Rule> rulesList) {
        this.rulesList = rulesList;
    }

    @NonNull
    @Override
    public RuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rule, parent, false);
        return new RuleViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull RuleViewHolder holder, int position) {
//        Rule rule = rulesList.get(position);
//        holder.titleTextView.setText(rule.getTitle());
//    }

    @Override
    public int getItemCount() {
        return rulesList.size();
    }

    public static class RuleViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView , ruleItemText;

        public RuleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.ruleTitle);
//            ruleItemText = itemView.findViewById(R.id.ruleItemText);
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RuleViewHolder holder, int position) {
        Rule rule = rulesList.get(position);
        holder.titleTextView.setText(rule.getTitle());


        String[] sentences = rule.getText().split("\\|");
        StringBuilder formattedText = new StringBuilder();
        for (String sentence : sentences) {
            formattedText.append(sentence.trim()).append("\n");
        }
        holder.titleTextView.setText(rule.getTitle().toString());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("title", rule.getTitle());
                intent.putExtra("text", rule.getText());
                view.getContext().startActivity(intent);
            }
        });
    }
}