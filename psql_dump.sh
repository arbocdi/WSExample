echo Enter: hostname  username local_filename datatabe
read hostn usern filen db
pg_dump --no-owner -h $hostn  -U $usern  --format=plain --file=$filen $db
