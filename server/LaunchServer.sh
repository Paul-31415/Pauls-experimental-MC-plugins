clear
echo 'How much ram would you like to give this server in Mb?'
read RAM

  java -Xms512m -Xmx"$RAM"m -XX:PermSize=256m -XX:ParallelGCThreads=2 -XX:+AggressiveOpts -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -jar CanaryMod.jar nogui
