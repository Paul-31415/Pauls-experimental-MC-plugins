clear
echo 'How much ram would you like to give this server? (defaults to Mb use b suffix for bytes)'
read RAM
ramend=${RAM:(${#RAM}-1)}
#echo $ramend
if [[ $ramend =~ [0-9] ]]; then 
    echo $RAM'Mb'
    java -Xms512m -Xmx"$RAM"m -XX:PermSize=256m -XX:ParallelGCThreads=2 -XX:+AggressiveOpts -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -jar CanaryMod.jar nogui
elif [[ $ramend =~ [kKmMgGtTpPeEzZyY] ]]; then
    echo ${RAM:0:(${#RAM}-1)}$ramend'b'
    java -Xms512m -Xmx"$RAM" -XX:PermSize=256m -XX:ParallelGCThreads=2 -XX:+AggressiveOpts -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -jar CanaryMod.jar nogui
elif [[ $ramend =~ [b] ]]; then
    echo ${RAM:0:(${#RAM}-1)}'b'
    java -Xms512m -Xmx"${RAM:0:(${#RAM}-1)}" -XX:PermSize=256m -XX:ParallelGCThreads=2 -XX:+AggressiveOpts -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -jar CanaryMod.jar nogui
else
    echo 'Error: unknown/disalowed si-prefix:"'$ramend'"'
fi