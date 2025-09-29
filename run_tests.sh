#!/usr/bin/env bash
set -e

INPUT_DIR=tests
BIN_DIR=bin

mkdir -p $BIN_DIR
javac -d $BIN_DIR src/*.java

for infile in $INPUT_DIR/*.in; do
    base=$(basename "$infile" .in)
    outfile="$INPUT_DIR/$base.out"

    echo "Running test $base ..."

    if diff -q <(java -cp $BIN_DIR Main < "$infile") "$outfile" > /dev/null; then
        echo "✅ Test $base passed"
    else
        echo "❌ Test $base failed"
        diff <(java -cp $BIN_DIR Main < "$infile") "$outfile"
        exit 1
    fi
done

