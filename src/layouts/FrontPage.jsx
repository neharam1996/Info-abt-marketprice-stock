import React, { Component } from "react";
export default class FrontPage extends Component {
  constructor(props) {
    super(props);
    this.state = { symbol: "" };

    this.onChange = this.onChange.bind(this);
    //This will bind this object with your event

    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }
  onSubmit(e) {
    e.preventDefault();
    console.log(this.state.symbol);
    this.props.history.push(`/price`, this.state.symbol);
  }

  render() {
    return (
      <div>
        <form onSubmit={this.onSubmit}>
          Enter the symbol of the stock to search
          <input
            type="text"
            name="symbol"
            value={this.state.symbol}
            onChange={this.onChange}
          />
          <input type="submit" name="Submit" />
        </form>
      </div>
    );
  }
}
