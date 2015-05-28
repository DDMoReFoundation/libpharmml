#! /bin/bash

def_dir="../src/eu/ddmore/libpharmml/impl/definitions/"

default_version="0.6"

old_version_dirs=("0_2_1" "0_3" "0_3_1" "0_4" "0_4_1" "0_5" "0_5_1")

for dir in "${old_version_dirs[@]}"
do
	current_dir=$def_dir$dir

	if [ -d $current_dir/default ]; then
	    rm -rv $current_dir/default
	fi

	mkdir -v $current_dir/default
	
	for file in $current_dir/*
	do
	    if [[ -f $file ]]; then
		perl defaultXSD.pl $file $default_version
	    fi
	done

	for j in $current_dir/*.out
	do
	    name=${j##*/}
	    mv -v $j "$current_dir/default/${name/.out}"
	done

done
