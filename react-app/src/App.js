/* eslint-disable no-unreachable */
import React, { Component } from "react";
import { HashRouter as Router, Route } from "react-router-dom";
import Todos from "./todos";
import Header from "./Header";
import AddTodo from "./AddTodo";
import About from "./About";
import Axios from "axios";
import "./App.css";
//import { v4 as uuid } from "uuid";

class App extends Component {
  state = {
    todos: [],
  };
  componentDidMount() {
    Axios.get(
      "https://jsonplaceholder.typicode.com/todos?_limit=25"
    ).then((response) => this.setState({ todos: response.data }));
  }
  markComplete = (id) => {
    this.setState({
      todos: this.state.todos.map((todo) => {
        if (todo.id === id) {
          todo.completed = !todo.completed;
        }
        return todo;
      }),
    });
  };
  // Delete Todo
  deleteTodo = (id) => {
    Axios.delete(`https://jsonplaceholder.typicode.com/todos/${id}`).then(
      (res) =>
        this.setState({
          todos: [...this.state.todos.filter((todo) => todo.id !== id)],
        })
    );
  };
  // Add Todo
  addTodo = (title) => {
    Axios.post("https://jsonplaceholder.typicode.com/todos", {
      title,
      completed: false,
    }).then((response) =>
      this.setState({ todos: [...this.state.todos, response.data] })
    );
  };

  render() {
    return (
      <Router>
        <div className="App">
          <div className="container">
            <Header />
            <Route
              exact
              path="/"
              render={(props) => (
                <React.Fragment>
                  <AddTodo addTodo={this.addTodo} />
                  <Todos
                    todos={this.state.todos}
                    markComplete={this.markComplete}
                    deleteTodo={this.deleteTodo}
                  />
                </React.Fragment>
              )}
            />
            <Route path="/about" component={About}></Route>
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
