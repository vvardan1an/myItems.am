package am.itspace.taskmanagement.controller;

import am.itspace.taskmanagement.entity.Task;
import am.itspace.taskmanagement.entity.User;
import am.itspace.taskmanagement.repository.TaskRepository;
import am.itspace.taskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @GetMapping("/tasks")
    public String tasks(ModelMap modelMap) {
        List<Task> all = taskRepository.findAll();
        modelMap.addAttribute("tasks", all);
        return "tasks";
    }

    @GetMapping("/tasks/add")
    public String addTaskPage(){
        return "addTask";
    }

    @PostMapping("/tasks/add")
    public String addTask(@ModelAttribute Task task){

        taskRepository.save(task);

        return "redirect:/tasks";
    }
}
