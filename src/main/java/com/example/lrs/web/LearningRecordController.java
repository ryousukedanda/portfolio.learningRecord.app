package com.example.lrs.web;

import com.example.lrs.domain.learningRecord.LearningRecordForm;
import com.example.lrs.domain.learningRecord.LearningRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    }

    //学習記録フォーム表示
    @GetMapping("/form")
    public String showForm(@ModelAttribute LearningRecordForm learningRecordForm){
        return "learningRecord/form";
    }

    //学習記録登録
    @PostMapping("/create")
    public String createForm(@ModelAttribute LearningRecordForm learningRecordform){
        learningRecordService.createList(learningRecordform);
        return "redirect:learningRecord/list";
    }
}
