import React, { Component } from "react";
import axios from "axios";

export default class Display extends Component {
  constructor(props) {
    super();
    this.state = {
      stock: "",
      done: 0,
      symbol: props.location.state,
    };
    console.log(props.location.state);
  }
  componentDidMount() {
    axios
      .get("http://localhost:9010/stock/" + this.state.symbol)
      .then((res) => res.data)
      .then((data) => {
        this.setState({ stock: data });
      });
  }

  render() {
    if (this.state.stock !== "") {
      return (
        <div>
          Price of stock {this.state.stock.name} is {this.state.stock.price}
          <br></br>
          <a href="/">More price check</a>
        </div>
      );
    } else {
      return (
        <div>
          Kindly enter the correct symbol
          <br></br>
          <a href="/">More price check</a>
        </div>
      );
    }
  }
}
