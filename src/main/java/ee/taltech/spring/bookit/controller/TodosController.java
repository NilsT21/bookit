package ee.taltech.spring.bookit.controller;

import ee.taltech.spring.bookit.domain.Todo;
import ee.taltech.spring.bookit.service.TodosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("todos")
public class TodosController {

    @Resource
    TodosService todosService;

    @GetMapping(value = "/{id}")
    public String getTodoById(Model model, @PathVariable Long id) {
        Todo todo = todosService.getTodo(id);
        model.addAttribute("example_todo", todo);
        return "todos";
    }

    @GetMapping()
    public String getAllTodos(Model model) {
        List<Todo> allTodos = todosService.findAllTodos();
        model.addAttribute("todos", allTodos);
        return "todo-list";
    }

    @PostMapping("form")
    public @ResponseBody
    Todo addTodo(@ModelAttribute Todo todo) {
        Todo result = todosService.addTodo(todo);
        return result;
    }

    @GetMapping("form")
    public String getForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PutMapping
    @ResponseBody
    public Todo setTodoDone(Long id) {
        todosService.setTodoDone(id);
        return todosService.getTodo(id);
    }
}
