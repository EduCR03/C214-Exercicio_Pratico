sudo apt-get install mailutils
echo "Fim da instalacao"
echo "Mandando um e mail para falar que nosso projeto tem integracao continua" | mail -s "a subject" ${EMAIL_LIST}