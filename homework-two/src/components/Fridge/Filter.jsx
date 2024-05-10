import React, { Component } from 'react';
import Card from '../UI/Card';

export default class Filter extends Component {
  constructor({ product, category }) {
    super();
    this.sorted = [];
    this.category = category;
    this.product = product;
    this.state = { category: this.category, product: this.product };
  }

  componentDidMount() {
    this.sorted = this.product;
  }

  componentDidUpdate(prevProps, prevState) {
    if (
      prevProps.category.localeCompare(this.state.category) ||
      JSON.stringify(prevProps.product) !== JSON.stringify(this.state.product)
    ) {
      this.setState((prevState) => ({
        ...prevState,
        category: prevProps.category,
        product: prevProps.product,
      }));

      this.sorted =
        prevProps.category === 'all'
          ? prevProps.product
          : prevProps.product.filter(
              (product) => product.category === prevProps.category
            );
    }
  }

  render() {
    return (
      <div className='flex flex-row min-h-[30vh] xl:min-h-[40vh] ml-[5vw] xl:ml-[12vw] w-screen items-center justify-start p-4 mb-4 xl:w-[60vw] gap-5 flex-wrap'>
        {this.sorted.length > 0 &&
          this.sorted.map((product) => {
            return (
              <Card
                key={Math.random()}
                styleOptions={
                  'w-96 p-4 h-[20vh] flex flex-col justify-center items-center'
                }
              >
                <ul>
                  <li>Product: {product.name}</li>
                  <li>Amount: {product.amount}</li>
                  <li>Expiration Date: {product.date}</li>
                </ul>
              </Card>
            );
          })}
      </div>
    );
  }
}
