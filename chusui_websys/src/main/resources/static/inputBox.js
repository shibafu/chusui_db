.text, textarea, .dropdown{
    border:1px solid #777;
    padding: 5px;
    color: #999;
    background: #fff;

/* Webkit */
    background: -webkit-gradient(
        linear,
        left top,
        left bottom,
        from(#eee),
        to(#fff)
        );

/* Firefox */
    background: -moz-linear-gradient(
        top,
        #eee,
        #fff
        );

/* IE */
    filter:progid:DXImageTransform.Microsoft.gradient
        (startColorstr=#ffeeeeee,endColorstr=#ffffffff);
    zoom: 1;
}