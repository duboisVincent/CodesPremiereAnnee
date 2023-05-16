<?php
print(preg_match('/abr/','abricot'));
print(" \n");
print(preg_match('/@free\.fr/','toto@free.fr'));
print(" \n");
print(preg_match('/^salut/','salut les jeunes'));
print(" \n");
print(preg_match('/au revoir$/','a plus au revoir'));
print(" \n");
print(preg_match('/^[0-9].*[a-z]{2}.*[A-Z]$/','0azA'));
print(" \n");
print(preg_match('/^[^0-9].*azerty/','Kazerty'));
print(" \n");
print(preg_match('/https:\/\/www\..*\.com/','https://www.laposte.com'));
print(" \n");
print(preg_match('/^[^@].+@[^@]+\.+[^@]+$/','toto@gmail.com'));
print(" \n");
print(preg_match('/^(59)[0-9]{3}/','59390'));
print(" \n");
?>

