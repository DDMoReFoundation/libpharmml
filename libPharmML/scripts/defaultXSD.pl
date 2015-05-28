#! /usr/bin/perl -w

use strict;


my ($file,$version) = @ARGV;

open(IN, $file) or die $!;
open(OUT, ">$file.out") or die $!;
while (<IN>) {
    s/http:\/\/www\.pharmml\.org\/2013\/03\/Maths/http:\/\/www\.pharmml\.org\/pharmml\/$version\/Maths/;
    s/http:\/\/www\.pharmml\.org\/2013\/08\/Dataset/http:\/\/www\.pharmml\.org\/pharmml\/$version\/Dataset/;
    s/http:\/\/www\.pharmml\.org\/2013\/03\/PharmML/http:\/\/www\.pharmml\.org\/pharmml\/$version\/PharmML/;
    s/http:\/\/www\.pharmml\.org\/2013\/03\/TrialDesign/http:\/\/www\.pharmml\.org\/pharmml\/$version\/TrialDesign/;
    s/http:\/\/www\.pharmml\.org\/2013\/03\/CommonTypes/http:\/\/www\.pharmml\.org\/pharmml\/$version\/CommonTypes/;
    s/http:\/\/www\.pharmml\.org\/2013\/03\/ModellingSteps/http:\/\/www\.pharmml\.org\/pharmml\/$version\/ModellingSteps/;
    s/http:\/\/www\.pharmml\.org\/2013\/03\/ModelDefinition/http:\/\/www\.pharmml\.org\/pharmml\/$version\/ModelDefinition/;
    print OUT $_;
}
close IN;
close OUT;
