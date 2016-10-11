var React = require('react');

var List = React.createClass({
  render: function(){
    var styles = {
      uList: {
        paddingLeft: 0,
        listStyleType: "none"
      },
      listGroup: {
        margin: '5px 0',
        borderRadius: 5
      },
      removeItem: {
        fontSize: 20,
        float: "right",
        position: "absolute",
        top: 12,
        left: 6,
        cursor: "pointer",
        color: "rgb(222, 79, 79)"
      },
      todoItem: {
        paddingLeft: 20,
        fontSize: 17
      }
    };
    var listItems = this.props.items.map(function(item, index){
      return (
        <li id={item.id} className="list-group-item" style={styles.listGroup}>
          <span
            className="glyphicon glyphicon-remove"
            style={styles.removeItem}
            onClick={this.props.remove.bind(null, item.id)}>
          </span>
          <div style={styles.todoItem}>
            {item.todo} ({item.dateTime[0]}-{item.dateTime[1]}-{item.dateTime[2]}  {item.dateTime[3]}:{item.dateTime[4]})
          </div>
          <span
              className="glyphicon glyphicon-pencil"
              onClick={this.props.update.bind(null, item.id)}
              id="updateIcon">
          </span>
        </li>
      )
    }.bind(this));
    return (
      <ul style={styles.uList}>
        {listItems}
      </ul>
    )
  }
});

module.exports = List;