import { useState } from "react";

const TodoForm = ({ addTodo }) => {
  const [todoText, setTodoText] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();

    if (todoText.trim() === "") {
      return;
    }

    addTodo(todoText.trim());

    setTodoText("");
  };

  return (
    <form className="todo-form" onSubmit={submitHandler}>
      <input
        type="text"
        placeholder="Enter a new task"
        value={todoText}
        onChange={(e) => setTodoText(e.target.value)}
      />

      <button type="submit">Add</button>
    </form>
  );
};

export default TodoForm;
