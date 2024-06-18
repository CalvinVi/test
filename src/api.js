const express = require('express');
const router = express.Router();

let todos = []; // In-Memory-Datenbank für Todos

// GET /api/todos - Alle Todos abrufen
router.get('/todos', (req, res) => {
  res.json(todos);
});

// POST /api/todos - Neues Todo hinzufügen
router.post('/todos', (req, res) => {
  const newTodo = {
    id: todos.length + 1,
    content: req.body.content,
    category: req.body.category,
    done: req.body.done || false,
    createdAt: new Date().getTime()
  };
  todos.push(newTodo);
  res.json(newTodo);
});

// DELETE /api/todos/:id - Todo löschen
router.delete('/todos/:id', (req, res) => {
  const { id } = req.params;
  todos = todos.filter(todo => todo.id !== parseInt(id, 10));
  res.status(204).send(); // Kein Inhalt zurückgeben, nur Statuscode 204
});

module.exports = router;