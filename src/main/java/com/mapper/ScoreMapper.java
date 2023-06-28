package com.mapper;

import com.entitle.Score;
import com.entitle.ScoreInfo;

import java.util.HashMap;
import java.util.List;

public interface ScoreMapper {
    int selectScoreCount(HashMap hm);
    List<Score> selectScore(HashMap hm);

    int insertScore(ScoreInfo si);

    public int selectAllScoreCount();

    public List<ScoreInfo> selectAllScore(HashMap hm);

    public int updateScore(ScoreInfo u);

    public int deleteScore(HashMap hm);

    List<ScoreInfo> selectScoreByCondition(HashMap hm);
    int selectScoreByConditionCount(HashMap hm);

    List<ScoreInfo> selectScoreByInterval(HashMap hm);

    int selectScoreByIntervalCount(HashMap hm);
}
