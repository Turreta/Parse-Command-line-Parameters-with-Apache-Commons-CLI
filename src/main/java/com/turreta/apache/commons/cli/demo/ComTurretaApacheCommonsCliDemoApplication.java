package com.turreta.apache.commons.cli.demo;

import org.apache.commons.cli.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComTurretaApacheCommonsCliDemoApplication
{

	public static void main(String[] args) throws ParseException
	{
		Options options = new Options();
		Option sourceOption = Option.builder("s")
				.required(true)
				.hasArg(true)
				.longOpt("source")
				.desc("Full path to the source file")
				.build();

		final Option deleteSourceOnExit = Option.builder("dsoe")
				.required(false)
				.longOpt("delete-source-on-exit")
				.desc("Option to delete source file on program exit")
				.build();

		options.addOption(sourceOption);
		options.addOption(deleteSourceOnExit);

		CommandLineParser cliParser = new DefaultParser();
		CommandLine cmdLine = cliParser.parse(options, args);

		System.out.println("Source: " + cmdLine.getOptionValue("s"));
		System.out.println("Delete source on exit: " + cmdLine.hasOption("dsoe"));
	}
}
