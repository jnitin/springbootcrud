package com.jnitin.demo.bootstrap;

import com.jnitin.demo.model.Todo;
import com.jnitin.demo.model.TodoStatus;
import com.jnitin.demo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader implements CommandLineRunner {
    public final TodoRepository todoRepository;

    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        if (todoRepository.count() == 0) {
            todoRepository.save(
                    Todo.builder()
                            .title("Study")
                            .description("Spring Boot")
                            .todoStatus(TodoStatus.COMPLETED)
                            .build()
            );
            todoRepository.save(
                    Todo.builder()
                            .title("Study")
                            .description("ER subsystem")
                            .todoStatus(TodoStatus.COMPLETED)
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
