function add()
{
	var i = 0
    	var div_element = document.createElement("div");
	var error_element
	div_element.innerHTML = '<hr>Title: <br><input type="text" name="title" size="50" value="試験文字列"><br>Contents: <br><textarea name="contents" rows="30" cols="100">試験\n試験\n試験</textarea>';
	var parent_object = document.getElementById("piyo");
	parent_object.appendChild(div_element);
}