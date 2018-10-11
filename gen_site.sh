#!/bin/sh

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @ Copyright (c) Michael Leachim                                                      @
# @ You can find additional information regarding licensing of this work in LICENSE.md @
# @ You must not remove this notice, or any other, from this software.                 @
# @ All rights reserved.                                                               @
# @@@@@@ At 2018-11-10 19:16 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

cd $(dirname "$0"); # cd to script dir

echo "BEGINNING UPLOAD PROCEDURE"
wget \
     --recursive \
     --mirror  \
     --page-requisites \
     --html-extension \
     --restrict-file-names=windows \
     --no-parent \
     127.0.0.1:3000;
rm -r ./out/*
mv 127.0.0.1+3000/* out/;
rm -r 127.0.0.1+3000/;
cd out;
rclone sync . s3:wireframecss.michaelleahcim.com  --progress;
cd ../;
echo "DONE;"



