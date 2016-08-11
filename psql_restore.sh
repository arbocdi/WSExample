echo Enter: hostname username dbname filename
read hostn usern dbn filen
psql -h $hostn -U $usern $dbn < $filen