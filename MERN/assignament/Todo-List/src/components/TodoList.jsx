const TodoList = ({ todos, deleteTodo, toggleTodo }) => {
  if (todos.length === 0) {
    return <p className="empty-message">No tasks available.</p>;
  }

  return (
    <div className="todo-list">
      {todos.map((todo) => (
        <div className="todo-item" key={todo.id}>
          <div className="todo-content">
            <input
              type="checkbox"
              checked={todo.completed}
              onChange={() => toggleTodo(todo.id)}
            />

            <span className={todo.completed ? "completed" : ""}>
              {todo.text}
            </span>
          </div>

          <button className="delete-button" onClick={() => deleteTodo(todo.id)}>
            Delete
          </button>
        </div>
      ))}
    </div>
  );
};

export default TodoList;
