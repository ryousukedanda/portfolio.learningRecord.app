package com.example.lrs.web;

import com.example.lrs.domain.learningRecord.LearningRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/learningRecord")
@Controller
public class LearningRecordController {

    private final LearningRecordService learningRecordService;

    //学習記録リスト表示
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("learningList",learningRecordService.showList());
        return "learningRecord/list";

    };
}
