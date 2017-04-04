<?
$PORT = 1234; 
$HOST = "localhost"; 

$sock = socket_create(AF_INET, SOCK_STREAM, 0) 
		or die("error: could not create socket\n");

$succ = socket_connect($sock, $HOST, $PORT) 
		or die("error: could not connect to host\n");

$text = " ";
while($text!="exit")
{
	socket_write($sock, $text . "\n", strlen($text) + 1) 
		or die("error: failed to write to socket\n");

	$reply = socket_read($sock, 10000, PHP_NORMAL_READ) 
		or die("error: failed to read from socket\n");
}



echo $reply;
?>
