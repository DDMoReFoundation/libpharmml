#! /usr/bin/perl -w

use strict;

my $file = shift @ARGV;

open(IN, $file) or die $!;

while (<IN>) {
    chomp;
    my ($raw,$trimmed) = split "\t", $_;
    $raw =~ s/\.java$//;
    
    print qq
|<jxb:bindings node="//xs:complexType[\@name='$raw']">
    <jxb:class name="$trimmed"/>
</jxb:bindings>
|;
}


close IN;