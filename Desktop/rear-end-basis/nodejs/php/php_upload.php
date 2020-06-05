//试验按一个文件上传的php 
<?php>
move_uploaded_file($_FILES['pic']['tmp_name'],'./'.$_FILES['pic']['name']);