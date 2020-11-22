gcloud beta compute ssh --zone "us-central1-f" "cluster-d9fd-m" --project "wordcountproject-293519" << EOF
hadoop jar wordCountProj.jar /textFiles/Miserables.txt /textFiles/NotreDame_De_Paris.txt /textFiles/anna_karenhina.txt /textFiles/out20.txt 10

EOF
