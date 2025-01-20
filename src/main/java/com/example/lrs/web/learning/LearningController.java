package com.example.lrs.web.learning;

import com.example.lrs.domain.learningRecord.LearningEntity;
import com.example.lrs.domain.learningRecord.LearningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/learningRecord")
@Controller
public class LearningController {

    private final LearningService learningService;

    //一覧表示
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("learningList", learningService.showList());
        return "learningRecord/list";
    }

    //フォーム表示
    @GetMapping("/form")
    public String showForm(@ModelAttribute LearningForm learningForm){
        return "learningRecord/form";
    }

    //登録
    @PostMapping("/create")
    public String create(@ModelAttribute @Validated LearningForm learningForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "learningRecord/form";  // バリデーションエラーがあればフォーム画面を再表示
        }
        // LearningForm を LearningEntity に変換
        LearningEntity learningEntity = LearningMapper.INSTANCE.toEntity(learningForm);
        // 学習記録を登録
        learningService.createList(learningEntity);
        return "redirect:/learningRecord/list";  // 登録後は一覧ページにリダイレクト
    }

    //編集画面表示
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") long id,Model model){
        // データベースから LearningEntity を取得
        LearningEntity learningEntity = learningService.showEdit(id);

        // MapStruct を使って LearningEntity を LearningForm に変換
        LearningForm learningForm = LearningMapper.INSTANCE.toForm(learningEntity);

        // モデルに LearningForm を渡す
        model.addAttribute("learningForm", learningForm);

        return "learningRecord/edit"; // 編
    }

    //学習記録更新
    @PostMapping(value = "/edit", params = "action=update")
    public String update(@ModelAttribute @Validated LearningForm learningForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "learningRecord/edit";  // バリデーションエラーがあればフォームを再表示
        }
        // LearningForm を LearningEntity に変換
        LearningEntity learningEntity = LearningMapper.INSTANCE.toEntity(learningForm);
        // 学習記録を更新
        learningService.update(learningEntity);
        return "redirect:/learningRecord/list";  // 更新後はリストページにリダイレクト
    }
    //学習記録削除
    @PostMapping(value = "/edit", params = "action=delete")
    public String delete(@ModelAttribute LearningForm learningForm) {
        // LearningForm を LearningEntity に変換
        LearningEntity learningEntity = LearningMapper.INSTANCE.toEntity(learningForm);
        // 削除処理
        learningService.delete(learningEntity.getId());
        return "redirect:/learningRecord/list";

    }

}
