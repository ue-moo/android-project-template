#!/bin/bash
set -e

repo_url=#TODO
path=src/openapi.yaml # TODO: パスが変更されたら変更
TARGET_BRANCH="$1"
#TARGET_BRANCH=${TARGET_BRANCH:-develop}

trap "rm -rf tmp_swagger" EXIT
mkdir -p tmp_swagger
if [[ $TARGET_BRANCH == "" ]]; then
    git clone --quiet $repo_url tmp_swagger/
    git -C tmp_swagger branch -r|egrep "^  origin/(develop|master|main)"|sed "s| *origin/||"
    echo -n "どのブランチから生成しますか？(未入力で終了) : "
    read TARGET_BRANCH
    if [[ $TARGET_BRANCH == "" ]]; then
        exit 0
    fi
    git -C tmp_swagger checkout "$TARGET_BRANCH"
else
    git clone -b "$TARGET_BRANCH" --depth=1 $repo_url tmp_swagger/
fi
cp tmp_swagger/$path ./

./gradlew :apiclient:apiClientGenerator --rerun-tasks
