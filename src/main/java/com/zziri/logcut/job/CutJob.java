package com.zziri.logcut.job;

import java.util.List;
import java.util.regex.Pattern;

public class CutJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 2;
    }

    @Override
    public String getName() {
        return "cut";
    }

    @Override
    public List<String> run(List<String> lines) {
        Pattern startPattern = Pattern.compile(lines.get(0));
        Pattern endPattern = Pattern.compile(lines.get(1));

        int startIndex = getMatchIndex(lines, 0, startPattern);
        int endIndex = getMatchIndex(lines, startIndex+1, endPattern);

        return lines.subList(startIndex, endIndex+1);
    }

    private int getMatchIndex(List<String> lines, int start, Pattern pattern) {
        int ret = lines.size()-1;
        for (int i=start; i<lines.size(); i++) {
            if (pattern.matcher(lines.get(i)).find()) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
