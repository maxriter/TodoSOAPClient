"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;

var Header = React.createClass({
    render: function() {
        return (
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                        <li><Link to="app">Home</Link></li>
                        <li><Link to="todo">Todo list</Link></li>
                        <li><Link to="search">Search panel</Link></li>
                    </ul>
                </div>
            </nav>
        );
    }
});

module.exports = Header;