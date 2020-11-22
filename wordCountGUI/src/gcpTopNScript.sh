gcloud beta compute ssh --zone "us-central1-f" "cluster-d9fd-m" --project "wordcountproject-293519" << EOF
hadoop jar topN.jar $1 $2 $3  $4 $5
hadoop fs -cat /textFiles/out46.txt/*
hadoop fs -rm -r /textFiles/out46.txt/*
hadoop fs -rm -r /textFiles/out46.txt
EOF
